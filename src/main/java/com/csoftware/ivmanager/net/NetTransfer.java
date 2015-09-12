package com.csoftware.ivmanager.net;

import com.csoftware.ivmanager.model.*;
import com.csoftware.ivmanager.net.impl.*;
import com.google.gson.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetTransfer implements Runnable {
	
	public final List<NetAction> DISPATCH_QUEUE = Collections.synchronizedList(new ArrayList<NetAction>());
	public boolean run = true;
	
	public static void postRequest(String urlSuffix, Object object) {
		String url = "http://localhost:8080/" + urlSuffix;
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			HttpClientContext context = new HttpClientContext();
			
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope("localhost", 8080), new UsernamePasswordCredentials("Cheddy", "f990974d8bd704ab073495f7e5e5f67383fea6ea1eab9bb415e210f92a4286"));
			context.setCredentialsProvider(credsProvider);
			
			AuthCache authCache = new BasicAuthCache();
			authCache.put(targetHost, new BasicScheme());
			context.setAuthCache(authCache);
			
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		    GsonBuilder builder = new GsonBuilder();
		    builder.registerTypeAdapter(Date.class, new DateAdapter());
		    Gson gson = builder.create();
			
			urlParameters.add(new BasicNameValuePair("data", gson.toJson(object)));
			post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));
			HttpResponse response = client.execute(post, context);
			
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static class DateAdapter implements JsonSerializer<Date> , JsonDeserializer<Date>{

		@Override
		public JsonElement serialize(Date date, Type arg1, JsonSerializationContext arg2) {
			return new JsonPrimitive(date.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		}

		@Override
		public Date deserialize(JsonElement date, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
			return Date.valueOf(date.getAsString());
		}

	}
	
	
	
	@Override
	public void run() {
		while (run) {
			if (DISPATCH_QUEUE.size() > 0) {
				NetAction action = DISPATCH_QUEUE.get(0);
				action.process();
				DISPATCH_QUEUE.remove(action);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateHospital(Hospital hospital) {
		DISPATCH_QUEUE.add(new UpdateHospitalAction(hospital));
	}
	
	public void deleteHospital(Hospital hospital) {
		DISPATCH_QUEUE.add(new DeleteHospitalAction(hospital));
	}
	
	public void updateImpact(Impact impact) {
		DISPATCH_QUEUE.add(new UpdateImpactAction(impact));
	}
	
	public void deleteImpact(Impact impact) {
		DISPATCH_QUEUE.add(new DeleteImpactAction(impact));
	}
	
	public void updateStaffRank(StaffRank staffRank) {
		DISPATCH_QUEUE.add(new UpdateStaffRankAction(staffRank));
	}
	
	public void deleteStaffRank(StaffRank staffRank) {
		DISPATCH_QUEUE.add(new DeleteStaffRankAction(staffRank));
	}
	
	public void updatePatient(Patient patient) {
		DISPATCH_QUEUE.add(new UpdatePatientAction(patient));
	}
	
	public void deletePatient(Patient patient) {
		DISPATCH_QUEUE.add(new DeletePatientAction(patient));
	}
	
	public void updateStaff(CompleteStaff staff) {
		DISPATCH_QUEUE.add(new UpdateStaffAction(staff));
	}
	
	public void deleteStaff(CompleteStaff staff) {
		DISPATCH_QUEUE.add(new DeleteStaffAction(staff));
	}
	
	public void updateWard(CompleteWard ward) {
		DISPATCH_QUEUE.add(new UpdateWardAction(ward));
	}
	
	public void deleteWard(CompleteWard ward) {
		DISPATCH_QUEUE.add(new DeleteWardAction(ward));
	}
	
	@SuppressWarnings("unchecked")
	public void loadComboBox(ComboBox<?> box, Class<?> classs) {
		if(classs.getSimpleName().equals("Hospital")){
			loadHospitals((ComboBox<Hospital>) box);
		}else if(classs.getSimpleName().equals("StaffRank")){
			loadStaffRanks((ComboBox<StaffRank>) box);
		}else if(classs.getSimpleName().equals("Impact")){
			loadImpacts((ComboBox<Impact>) box);
		}else if(classs.getSimpleName().equals("CompleteWard")){
			loadWards((ComboBox<CompleteWard>) box);
		}else if(classs.getSimpleName().equals("Patient")){
			loadPatients((ComboBox<Patient>) box);
		}
	}
	
	public void loadStaffRanks(ComboBox<StaffRank> box) {
		DISPATCH_QUEUE.add(new LoadAllStaffRanksBoxAction(box));
	}
	
	public void loadHospitals(ComboBox<Hospital> box) {
		DISPATCH_QUEUE.add(new LoadAllHospitalsBoxAction(box));
	}
	
	public void loadImpacts(ComboBox<Impact> box) {
		DISPATCH_QUEUE.add(new LoadAllImpactsBoxAction(box));
	}
	
	public void loadPatients(ComboBox<Patient> box) {
		DISPATCH_QUEUE.add(new LoadAllPatientsBoxAction(box));
	}
	
	public void loadWards(ComboBox<CompleteWard> box) {
		DISPATCH_QUEUE.add(new LoadAllWardsBoxAction(box));
	}
	
	public void loadStaff(ListView<CompleteStaff> list) {
		DISPATCH_QUEUE.add(new LoadAllStaffListAction(list));
	}
	
	public void loadImpacts(ListView<Impact> list) {
		DISPATCH_QUEUE.add(new LoadAllImpactsListAction(list));
	}
	
	public void loadHospitals(ListView<Hospital> list) {
		DISPATCH_QUEUE.add(new LoadAllHospitalsListAction(list));
	}
	
	public void loadWards(ListView<CompleteWard> list) {
		DISPATCH_QUEUE.add(new LoadAllWardsListAction(list));
	}
	
	public void loadPatient(ListView<Patient> list) {
		DISPATCH_QUEUE.add(new LoadAllPatientsListAction(list));
	}
	
	public void loadStaffRanks(ListView<StaffRank> list) {
		DISPATCH_QUEUE.add(new LoadAllStaffRanksListAction(list));
	}
	
	public static String getRequest(String urlSuffix) {
		String url = "http://localhost:8080/" + urlSuffix;
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet post = new HttpGet(url);
			HttpClientContext context = new HttpClientContext();
			
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope("localhost", 8080), new UsernamePasswordCredentials("Cheddy", "f990974d8bd704ab073495f7e5e5f67383fea6ea1eab9bb415e210f92a4286"));
			context.setCredentialsProvider(credsProvider);
			
			AuthCache authCache = new BasicAuthCache();
			authCache.put(targetHost, new BasicScheme());
			context.setAuthCache(authCache);
			
			HttpResponse response = client.execute(post, context);
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
