package com.zoo;

public class Animal {

	private int id;
	private String AnimalName;
	private String CageNumber;
	private String FeedNumber;
	private String Breed;
	private String photo;
	private String Description;
	private String CreationDate;
	
	public Animal() {
		super();
	}

	public Animal(String animalName, String cageNumber, String feedNumber, String breed,String description) {
		super();
		AnimalName = animalName;
		CageNumber = cageNumber;
		FeedNumber = feedNumber;
		Breed = breed;
		//this.photo = photo;
		Description = description;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAnimalName() {
		return AnimalName;
	}
	public void setAnimalName(String animalName) {
		AnimalName = animalName;
	}

	public String getCageNumber() {
		return CageNumber;
	}
	public void setCageNumber(String cageNumber) {
		CageNumber = cageNumber;
	}

	public String getFeedNumber() {
		return FeedNumber;
	}
	public void setFeedNumber(String feedNumber) {
		FeedNumber = feedNumber;
	}

	public String getBreed() {
		return Breed;
	}
	public void setBreed(String breed) {
		Breed = breed;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	
	public int compareTo(Animal o) {
		return this.id>o.id ? -1 : 1;
	}
	
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", AnimalName=" + AnimalName + ", CageNumber=" + CageNumber + ", FeedNumber="
				+ FeedNumber + ", Breed=" + Breed + ", photo=" + photo + ", Description=" + Description
				+ ", CreationDate=" + CreationDate + "]";
	}	
}