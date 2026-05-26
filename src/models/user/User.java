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

	    // constructor
	    public User(
	            String id,
	            String carnet,
	            String name,
	            String lastname,
	            int age,
	            String phone,
	            String mail,
	            String address
	    ) {

	        this.id = Integer.parseInt(id);
	        this.carnet = carnet;
	        this.name = name;
	        this.lastname = lastname;
	        this.age = age;
	        this.phone = phone;
	        this.mail = mail;
	        this.address = address;
	    }

	    // getters y setters

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
	}

	