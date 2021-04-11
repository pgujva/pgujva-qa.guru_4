public class PracticeFormData {
  private final String name;
  private final String lastname;
  private final String email;
  private final String gender;
  private final String phone;
  private final String month;
  private final String year;
  private final String subject;
  private final String hobby;
  private final String address;
  private final String state;
  private final String city;

  public PracticeFormData(String name, String lastname, String email, String gender, String phone, String month, String year, String subject, String hobby, String address, String state, String city) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.gender = gender;
    this.phone = phone;
    this.month = month;
    this.year = year;
    this.subject = subject;
    this.hobby = hobby;
    this.address = address;
    this.state = state;
    this.city = city;
    
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getGender() {
    return gender;
  }

  public String getPhone() {
    return phone;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getSubject() {
    return subject;
  }

  public String getHobby() {
    return hobby;
  }

  public String getAddress() {
    return address;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }
}
