package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFromFile {

	public static List<Human> readFromFile(File file) {
		BufferedReader in = null;
		List<Human> humanlist = new ArrayList<Human>();
		try {
			in = new BufferedReader(new FileReader(file));
			String read = null;
			while ((read = in.readLine()) != null) {
				String[] splited = read.split(",");
				Human human = new Human(splited[0], Integer.parseInt(splited[1]));
				humanlist.add(human);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return humanlist;
	}

	public static int countUnique(List<Human> humans) {
		Set<String> set = new HashSet<String>();
		for (Human human : humans) {
			set.add(human.getName());
		}
		return set.size();
	}

	public static void main(String[] args) {
		File file = new File("C:/codecool/names.txt");
		List<Human> humanlist = readFromFile(file);
		for (Human human : humanlist) {
			System.out.println(human);
		}
		System.out.println(countUnique(humanlist));
		Comparator c = new HumanComparator();
		humanlist.sort(c);
		System.out.println(humanlist);
	}

}
