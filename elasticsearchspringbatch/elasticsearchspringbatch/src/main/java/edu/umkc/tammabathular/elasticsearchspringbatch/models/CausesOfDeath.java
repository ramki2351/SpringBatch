package edu.umkc.tammabathular.elasticsearchspringbatch.models;

public class CausesOfDeath {

	public int year;
	public String causeNameDesc;
	public String causeName;
	public String state;
	public int deaths;
	public int ageAdjustedDeathRate;


	public CausesOfDeath() {

	}

	public CausesOfDeath(int year, String causeNameDesc, String causeName, String state, int deaths,
			int ageAdjustedDeathRate) {

		this.state = state;
		this.causeNameDesc = causeNameDesc;
		this.year = year;
		this.causeName = causeName;
		this.deaths = deaths;
		this.ageAdjustedDeathRate = ageAdjustedDeathRate;

	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCauseNameDesc() {
		return causeNameDesc;
	}

	public void setCauseNameDesc(String causeNameDesc) {
		this.causeNameDesc = causeNameDesc;
	}

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAgeAdjustedDeathRate() {
		return ageAdjustedDeathRate;
	}

	public void setAgeAdjustedDeathRate(int ageAdjustedDeathRate) {
		this.ageAdjustedDeathRate = ageAdjustedDeathRate;
	}


}
