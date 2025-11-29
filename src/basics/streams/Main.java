import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );

        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

//        🔹 Basic Stream Operations
//        Filter even numbers from a list of integers.

        List<Integer> evenNumber = numbers.stream().filter(num->num%2==0).collect(Collectors.toList());
        System.out.println(evenNumber);

        //Find names starting with a specific letter from a list of strings.
        List<String> filteredName = names.stream().filter(name -> name!=null && !name.isEmpty()&& name.startsWith("A")).collect(Collectors.toList());
        System.out.println(filteredName);

        //Convert all strings to uppercase using stream.
        List<String> uppercaseName =names.stream().filter(name -> name!=null && !name.isEmpty()).map(name ->name.toUpperCase()).collect(Collectors.toList());
        System.out.println(uppercaseName);

        //Sort a list of integers in descending order using streams.
        List<Integer> sortedNumber = numbers.stream().sorted().collect(Collectors.toList()).reversed();
        System.out.println(sortedNumber);

        //Remove duplicate elements from a list using distinct().
        List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNumber);
//-----------------------------------------------------------------------------------------------------------------------------------------

//        🔹 Intermediate Stream Tasks
//        Count the number of strings longer than 5 characters.
        long counter = names.stream().filter(name-> name != null && !name.isEmpty() && name.length() > 5).count();
        System.out.println(counter);


        //Find the first element in a stream that matches a given condition
        //Check if any number is divisible by 5 in a list.

        Integer firstElement =numbers.stream().filter(num -> num %5 ==0).findFirst().get();
        System.out.println(firstElement);

        //Collect elements into a Set instead of a List.
        Set<Integer> setElement =numbers.stream().filter(num -> num %5 ==0).collect(Collectors.toSet());
        System.out.println(setElement);

        //Skip the first 3 elements and return the rest.
        List<Integer> skipNumber = numbers.stream().skip(3).collect(Collectors.toList());
        System.out.println(skipNumber);
        //-------------------------------------------------------------------------------------------------------------------

        //🔹 Numeric Streams & Reductions
        //Calculate the sum of a list of integers using reduce.
        Integer sumList = numbers.stream().reduce(0,(a,b)->(a+b));
        System.out.println(sumList);

        //Find the maximum and minimum value in a list.
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        // Find the minimum value in the list
        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);

        System.out.println(max.get());
        System.out.println(min.get());

        //Calculate the average of a list of doubles.
        Integer sumL = numbers.stream().reduce(0,(a,b)->(a+b));
        long avg = sumL/numbers.size();
        System.out.println(avg);

        //Multiply all integers in a list together using reduce.
        Integer multiply = numbers.stream().filter(num->num!=0).reduce((a, b)->(a * b)).get();
        System.out.println("multiply "+multiply);

//        Count how many numbers are positive in a list.
        Long ccount = numbers.stream().filter(num->num>0).count();
        System.out.println(ccount);
//-----------------------------------------------------------------------------------------------------------------------------------

//🔹 Collectors & Grouping
//        Group a list of students by their department.

        Map<String, List<Student>> groupedByDepartment = students.stream().collect(Collectors.groupingBy(Student :: getDepartment));
        System.out.println(groupedByDepartment);

//        Partition a list of numbers into even and odd using partitioningBy.
        Map<Boolean, List<Integer> > map = numbers.stream().collect(Collectors.partitioningBy(num -> num %2==0));
        System.out.println(map);

//        Create a comma-separated string from a list of strings.
        String commaString = names.stream().collect(Collectors.joining(","));
        System.out.println(commaString);

//        Group employees by age and count how many per age.
        Map<Integer,Long> GroupedEmployeeByAge = employees.stream().collect(Collectors.groupingBy(Employee :: getAge,Collectors.counting()));
        System.out.println(GroupedEmployeeByAge);


//        Find the average salary per department in a list of employees.
        Map<String,Double> avgSalaryPerDep = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryPerDep);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//🔹 Optional, Map, FlatMap
//        Flatten a list of lists into a single list.

        List<String> flattenedWords = nestedWords.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flattenedWords);

        //Extract all unique characters from a list of words.
        List<String> words = Arrays.asList("Java", "Stream", "API", "Lambda", "FlatMap", "Map");
        Set<Character> uniqueChars = words.stream().flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(Collectors.toSet());
        System.out.println(uniqueChars);

//        Filter a list of Optionals and collect non-empty values.
        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("Java"),
                Optional.empty(),
                Optional.of("Stream"),
                Optional.empty(),
                Optional.of("API")
        );
        List<String> nonEmptyValues = optionals.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
        System.out.println(nonEmptyValues);

//        Map a list of strings to their lengths.
        List<String> wordsList = Arrays.asList("Java", "Stream", "API", "Lambda", "Map");
        List<Integer> lengths = wordsList.stream().map(String::length).collect(Collectors.toList());
        System.out.println(lengths);

//        Return a list of uppercased words that start with “A”.
        List<String> uppercasedWords = wordsList.stream().filter(word -> word.startsWith("A")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercasedWords);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

//        🔹 Advanced Operations
//        Sort a list of employees by salary then by name.
        employees.sort(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName));
        employees.forEach(System.out::println);

//        Find the second highest number in a list.
        List<Integer> numb = Arrays.asList(10, 5, 3, 7, 2, 5, 10, 8, 9, 0, 4);
        Optional<Integer> secondHighest = numb.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighest.get());

//        Find duplicate elements in a list of integers.
        List<Integer> duplicates = numb.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate elements: " + duplicates);

//        Remove null or empty strings from a list using stream.
        List<String> listt = names.stream().filter(s -> s != null && !s.isEmpty()).collect(Collectors.toList());
        System.out.println("Cleaned list: " + listt);

//        Partition students into pass/fail groups based on grade.
        Map<Boolean, List<Student>> partitioned = students.stream()
                .collect(Collectors.partitioningBy(student -> student.grade >= 50));

        List<Student> passGroup = partitioned.get(true);
        List<Student> failGroup = partitioned.get(false);


    }

}