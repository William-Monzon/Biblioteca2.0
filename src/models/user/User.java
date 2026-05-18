package models.user;

public class User {
	
	private int id;
	private int age;
	private String phone;
	private String name;
	private String lastname;
	private String carnet;
	private String mail;
	private String address;
	
	// constructor vacio
	public User() {
		
	}
	

	//constructor 
	public User(int id, int age, String phone, String name, String lastname, String carnet, String mail, String address) {
		super();
		this.id = id;
		this.age = age;
		this.phone = phone;
		this.name = name;
		this.lastname = lastname;
		this.carnet = carnet;
		this.mail = mail;
		this.address = address;
	}
	


	// getters and setters
        
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCarnet() {
		return carnet;
	}


	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	// metodo para mostrar usuario
	public void showinf() {

        System.out.println(".....USER....");
        System.out.println("ID: " + id);
        System.out.println("AGE: " + age);
        System.out.println("PHONE NUMBER: " + phone);
        System.out.println("NAME: " + name);
        System.out.println("LAST NAME: " + lastname);
        System.out.println("CARNET: " + carnet);
        System.out.println("MAIL: " + mail);
        System.out.println("ADDRESS: " + address);
	}


	// string
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", phone=" + phone + ", name=" + name + ", lastname=" + lastname
				+ ", carnet=" + carnet + ", mail=" + mail + ", address=" + address + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
