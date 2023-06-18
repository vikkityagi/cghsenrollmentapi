package io.swagger.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalValidation {
    

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<Map<String, String>> bindException(BindException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}




	
	// protected ResponseEntity<Object> handleMethodArgsNotValidException(MethodArgumentNotValidException ex ,HttpHeaders headers,
	// 		  HttpStatus status,WebRequest request){
	// 			Map<String, Object> resp = new HashMap<>();
	// 			resp.put("timestamp", new Date());
	// 			resp.put("status",status.value());



	// 			List<FieldError> fielderrors =ex.getBindingResult().getFieldErrors();
	// 			List<String> list = new ArrayList<>();

	// 			for(FieldError fielderr :fielderrors){
	// 				String message = fielderr.getDefaultMessage();
	// 				list.add(message);
	// 			}
				
	// 			resp.put("errors", list);
	// 			return new ResponseEntity<>(resp,headers,status);
	// 		}

}
