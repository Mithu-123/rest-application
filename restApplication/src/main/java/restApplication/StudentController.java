package restApplication;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@GetMapping(path = "/details", produces = "application/json")
	public List<Student> getStudentDetails() {

		logger.trace("****************************getStudentDetails() called*****************");

		logger.trace("****************************preparedListOfAddress() called*****************");
		 preparedListOfAddress();

		/*
		 * final String uri = "http://localhost:8080/student/studentIdList";
		 * 
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 * 
		 * ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET,
		 * entity, String.class);
		 * 
		 * System.out.println("->>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+result);
		 */
		return studentRepository.findAll();
	}

	@GetMapping(path = "/studentIdList", produces = "application/json")
	public String preparedListOfStudentId() {

		logger.info("****************************preparedListOfStudentId() called*****************");
		List<String> studentIdList = new ArrayList<String>();
		String result = "0";
		int i = 0;
		studentIdList = studentRepository.findListOfStudentId();
		Iterator itr = studentIdList.iterator();
		while (itr.hasNext() && i < 100) {
			result = result + itr.next() + " ->";
			i++;
		}
		System.out.println("List Of StudentId>>>>>>>>>>>>>" + studentIdList);
		logger.info("****************************preparedListOfStudentId() Finished*****************");
		return result;

	}

	private void preparedListOfAddress() {

		List<String> addressList = new ArrayList<String>();
		addressList = studentRepository.findListOfAddress();
		System.out.println("List of address>>>>>>>>>>>>>>> " + addressList);

		logger.trace("****************************preparedListOfAddress() finished*****************");
		preparedListOfSchoolName();

	}

	private void preparedListOfSchoolName() {

		List<String> listOfSchoolName = new ArrayList<String>();
		listOfSchoolName = studentRepository.findListOfSchoolName();

		System.out.println("List schoolNames :>>>>>>>>>>>>>" + listOfSchoolName);

		preparedListOfSchoolAddress();

	}

	private void preparedListOfSchoolAddress() {

		List<String> listOfSchoolAddress = new ArrayList<String>();
		listOfSchoolAddress = studentRepository.findListOfSchoolAddress();

		System.out.println("List of School Address:>>>>>>>>>" + listOfSchoolAddress);

	}

	@PostMapping(path = "/create", consumes = "application/json")
	public String createStudent(@RequestBody Student student1) {
		logger.trace("****************************createStudent() called*****************");

		System.out.print("->>>" + student1);

		studentRepository.save(student1);
		return "Student Object Created";
	}

	@PutMapping(path = "/update/{id}/{address}")
	public String updateStudentDetails(@PathVariable Long id, @PathVariable String address) {

		logger.info("****************************updateStudentDetails() called*****************");

		studentRepository.updateAddress(id, address);

		return "Student Object updated";

	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteStudentDetails(@PathVariable Long id) {
		logger.trace("****************************deleteStudentDetails() called*****************");
		studentRepository.delete(id);
		return "Student Object Deleted";

	}

}
