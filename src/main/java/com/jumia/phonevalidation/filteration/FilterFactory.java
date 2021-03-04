package com.jumia.phonevalidation.filteration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
public class FilterFactory {
	@Autowired
	@Qualifier("CountryFilter")
	private CountryFilter countryFilter;
	
	@Autowired
	@Qualifier("StateFilter")
	private StateFilter stateFilter;
	
	@Autowired
	FilterStrategy filterStrategy;
	
	@Autowired
	Checker checker;
	
	protected List<Phone> filterByCountry(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones){
		filterStrategy.setAbstractFilter(countryFilter);
		return filterStrategy.getData(inMemorySearchRequest, inputPhones);
	}
	
	protected List<Phone> filterByState(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones){
		filterStrategy.setAbstractFilter(stateFilter);
		return filterStrategy.getData(inMemorySearchRequest, inputPhones);
	}
	
	protected Map<Predicate<InMemorySearchRequest>,BiFunction<InMemorySearchRequest, List<Phone>, List<Phone>>> getInstances(){
		Map<Predicate<InMemorySearchRequest>,BiFunction<InMemorySearchRequest, List<Phone>, List<Phone>>> instances = new LinkedHashMap<>();
		instances.put((inMemorySearchRequest)-> checker.checkCountryFilteration(inMemorySearchRequest), (inMemorySearchRequest,inputPhones)-> filterByCountry(inMemorySearchRequest, inputPhones));
		instances.put((inMemorySearchRequest)-> checker.checkStateFilteration(inMemorySearchRequest), (inMemorySearchRequest,inputPhones)-> filterByState(inMemorySearchRequest, inputPhones));

		return instances;
	}
	
	public List<Phone> getFilteredPhoneList(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones){
		Map<Predicate<InMemorySearchRequest>,BiFunction<InMemorySearchRequest, List<Phone>, List<Phone>>> values = getInstances();
		for(Entry<Predicate<InMemorySearchRequest>, BiFunction<InMemorySearchRequest, List<Phone>, List<Phone>>> entry: values.entrySet()) {
			if(entry.getKey().test(inMemorySearchRequest)) {
				return entry.getValue().apply(inMemorySearchRequest, inputPhones);
			}
		}
		return new ArrayList<Phone>();
	}
	
	
}
