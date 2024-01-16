function fn() {

	var config = {
		name: "Anand Ramkumar",
		baseURL: "https://reqres.in/",
		headerAccept: "application/json",
		headerTest: "TestHeader1234"

	}

	var env = karate.env
	karate.log("The value of env is : " , env);
	
	if(env == "qa") {
		config.baseURL = "https://reqres.in-qa/"
		config.headerTest = "qa environment"
	}
	else if(env == "dev") {
		config.baseURL = "https://reqres.in-dev/"
		config.headerTest = "dev environment"
	}
	else  {
		config.baseURL = "https://reqres.in/"
		config.headerTest = "all environment"
	}

	karate.configure("connectTimeout", 5000)
	karate.configure("readTimeout", 5000)
	return config


}