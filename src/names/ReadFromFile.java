package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
			in.close();
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

	public static void writeToFile(List<Human> humanlist, File file) {
		List<String> lines = new ArrayList<String>();
		for (Human human : humanlist) {
			lines.add(human.toString());
		}
		try {
			PrintWriter pw = new PrintWriter(file);
			for (String string : lines) {
				pw.write(string + "\n");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File file = new File("C:/codecool/names.txt");
		File output = new File("C:/codecool/output.txt");
		List<Human> humanlist = readFromFile(file);
		for (Human human : humanlist) {
			System.out.println(human);
		}
		System.out.println(countUnique(humanlist));
		Comparator<Human> c = new HumanComparator();
		humanlist.sort(c);
		writeToFile(humanlist, output);
	}

}
