package ca.lambtoncollege;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Email
	@NotNull
	private String email;

	@NotNull
	@Size(min = 2, max = 40)
	private String name;

	public Employee(@Email @NotNull String email, @NotNull @Size(min = 2, max = 40) String name, @NotNull Integer age) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
	}

	public Employee() {

	}

	public Employee(Object object, String string, String string2, int i) {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@NotNull
	private Integer age;

}
