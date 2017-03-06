package share;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Java8 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(){{add("a");add("b");}};
		List<String> list2 = new ArrayList<String>(){{add("b");add("a");}};
		System.out.println("result : " + list1.equals(list2));
		System.out.println("result : " + Objects.equals(list1, list2));
	}
}

class Person {
	String name;
	Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "name : " + name + " age : " + age;
	}
}