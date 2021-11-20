import java.util.Comparator;

import com.mybook.Person;

public enum SortOption {

	NAME(Comparator.comparing(Person::getFirstName)),
	CITY(Comparator.comparing(Person::getCity)),
    STATE(Comparator.comparing(Person::getState)),
    ZIP(Comparator.comparing(Person::getZip));
	
	public final Comparator<? super Person> comparator;
	
	SortOption(Comparator<? super Person> comparator) {

		this.comparator = comparator;
	}
	
}
