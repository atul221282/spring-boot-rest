package io.javabrains.sbs.topic;

import java.util.HashMap;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsCorrectTopicValidator implements ConstraintValidator<IsCorrectTopic, Topic> {

	@Override
	public void initialize(IsCorrectTopic arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Topic value, ConstraintValidatorContext context) {
		if (value == null)
			return true;
		HashMap<String, String> hm = new HashMap<String, String>();

		if (value.getName().isEmpty()) {
			hm.put("name", "Name is mandatory");
		}

		if (value.getDescription().isEmpty()) {
			hm.put("description", "Description is mandatory");
		}

		if (value.getId() == null) {
			hm.put("id", "Id is mandatory");
		}

		if (hm.isEmpty())
			return true;

		context.disableDefaultConstraintViolation();

		for (String errorKey : hm.keySet()) {
			context.buildConstraintViolationWithTemplate(hm.get(errorKey)).addPropertyNode(errorKey)
					.addConstraintViolation();
		}

		return false;
	}

}
