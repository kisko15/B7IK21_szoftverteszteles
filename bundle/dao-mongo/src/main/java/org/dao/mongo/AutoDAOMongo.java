package org.dao.mongo;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.dao.AutoDao;
import hu.uni.miskolc.teszteles.dao.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.dao.exception.RendszerMarFoglalt;

public class AutoDAOMongo implements AutoDao {
	
	private MongoCollection<AutoPojo> collection;
	
	public AutoDAOMongo(String uri, String database, String collection) {
		ConnectionString connection = new ConnectionString(uri);
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), 
				pojoCodecRegistry);
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connection).
				codecRegistry(codecRegistry).build();
		
		MongoClient client = MongoClients.create(clientSettings);
		MongoDatabase db = client.getDatabase(database);
		this.collection = db.getCollection(collection, AutoPojo.class);
	}
	

	@Override
	public Collection<Auto> readAllAutos() {
		return collection.find().map(AutoPojoConverter::pojoToAutoConvert).into(new ArrayList());
		
	}

	@Override
	public Auto readAutoById(String rendszam) throws AutoNemTalalhato, RednszamNemMegfelelo {
	return collection.find(eq("_id",rendszam)).map(AutoPojoConverter::pojoToAutoConvert).first();
	}

	@Override
	public void createAuto(Auto auto) throws RendszerMarFoglalt {
		try {
		collection.insertOne(AutoPojoConverter.autoToPojoConvert(auto));}
		catch (MongoWriteException e) {
			throw new RendszerMarFoglalt(auto.getRendszam());
		}

	}

	@Override
	public void updateAuto(Auto auto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAuto(Auto auto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAutoById(String rendszam) {
		// TODO Auto-generated method stub

	}

}