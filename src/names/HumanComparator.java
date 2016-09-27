package names;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

	@Override
	public int compare(Human o1, Human o2) {
		int nameDiff = o1.getName().compareTo(o2.getName());

		if (nameDiff != 0) {
			return nameDiff;
		}
		int ageDiff = o1.getAge() - o2.getAge();

		return ageDiff;
	}

}
