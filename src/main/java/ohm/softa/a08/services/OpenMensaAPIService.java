package ohm.softa.a08.services;

import ohm.softa.a08.api.OpenMensaAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenMensaAPIService {

	private static final OpenMensaAPIService instance = new OpenMensaAPIService();
	private OpenMensaAPI mensaApiInstance;

	private OpenMensaAPIService() {
		var retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("http://openmensa.org/api/v2/")
			.build();

		mensaApiInstance = retrofit.create(OpenMensaAPI.class);
	}

	public static OpenMensaAPIService getInstance() {
		return instance;
	}

	public OpenMensaAPI getOpenMensaAPI() {
		return mensaApiInstance;
	}
}
