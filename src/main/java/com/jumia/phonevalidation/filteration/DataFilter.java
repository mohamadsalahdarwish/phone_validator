package com.jumia.phonevalidation.filteration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
public class DataFilter {
	public Map<String ,List<Phone>> groupByCountry(List<Phone> phoneList){
		return phoneList.stream()
				  .collect(Collectors.groupingBy(Phone::getCountry));
	}
	
	public Map<String ,List<Phone>> groupByValidaty(List<Phone> phoneList){
		return phoneList.stream()
				  .collect(Collectors.groupingBy(Phone::getState));
	}
	
}
