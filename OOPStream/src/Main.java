import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //testLambdaFunction();

        // Lo Stream è un interfaccia che mi restituisce un flusso di dati
        // su cui è possibile fare delle operazioni.

        // La sorgente di uno Stream è l'elemento che lo genera
        // Collection, Array, Stream

        Collection<String> c = new ArrayList<String>();
        c.add("Java");
        c.add("Javascript");
        c.add("Python");
        c.add("C#");
        c.add("NodeJs");
        c.add("Php");

        String[] arr = {"Java","Javascript","Python","C#","NodeJs","Php"};

        List<String> l1 = Arrays.asList(arr);

        List<String> l2 = Arrays.asList("Java","Javascript","Python","C#","NodeJs","Php");

//        Random rand = new Random();
//        double d = rand.nextDouble();

        // Sorgente di uno Stream
        Stream<String> myStream1 = c.stream();
        Stream<String> myStream2 = Stream.of("Java","Javascript","Python","C#","NodeJs","Php");
        Stream<Integer> myStream3 = Stream.iterate(0, n -> n+2).limit(10);
        Stream<Double> myStream4 = Stream.generate(new Random()::nextDouble).limit(10);
        Stream<String> myStream5 = Stream.<String>builder().add("Java").add("Javascript").add("Python").build();

        //myStream1.forEach(s -> System.out.println(s));

        // Posso operare su uno Stream in due modi:
        // -> Tramite Operazioni intermedie
        // -> Tramite Operazioni finali

        // Operazioni intermedie
        // Sono tutte quelle operazioni che effettuano delle trasformazioni dello Stream
        // e restituiscono uno Stream modificato
        // Le operazioni intermedie possono essere concatenate e la concatenzione di
        // operazioni intermedie viene chiamata pipeline
        // Le operazioni intermedie si dividono in:
        //  -> iteration
        //  -> filtering
        //  -> mapping

        Stream<String> myStream = Stream.of("Java","Javascript","Python","C#","Java","NodeJs","Php");
//        Stream<String> myStreamDistinct = myStream.distinct();
//        Stream<String> myStreamFilter = myStreamDistinct.filter(str -> str.length() > 3);
//        Stream<String> myStreamSorted = myStreamFilter.sorted();
//        myStream.forEach(System.out::println);
        List<String> listaMod = myStream.distinct()
                .filter(str -> str.length() > 3)
                .map(str -> str + "!!!")
                .sorted()
                .limit(3)
                //.forEach(System.out::println);
                .toList();


        List<User> userList = new ArrayList<User>();
        userList.add(new User("Mario", "Rossi", "Roma", 45));
        userList.add(new User("Giuseppe", "Verdi", "Milano", 21));
        userList.add(new User("Francesca", "Neri", "Napoli", 32));
        userList.add(new User("Antonio", "Bianchi", "Roma", 29));
        userList.add(new User("Simona", "Viola", "Palermo", 41));

        userList.get(0).getHobby().add("Calcio");
        userList.get(0).getHobby().add("Padel");
        userList.get(2).getHobby().add("Calcio");
        userList.get(3).getHobby().add("Golf");
        userList.get(3).getHobby().add("Calcio");
        userList.get(1).getHobby().add("Padel");
        userList.get(1).getHobby().add("Calcio");
        userList.get(4).getHobby().add("Calcio");

        //userList.get(3).getHobby().forEach(System.out::println);

        //userList.stream().filter(u -> u.getAge() > 30).forEach(System.out::println);
        OptionalDouble age = userList.stream()
                .mapToInt(User::getAge)
                //.forEach(System.out::println);
                //.max();
                //.min();
                //.sum();
                .average();
        System.out.println(age.getAsDouble());

        userList.stream()
                .flatMap(u -> u.getHobby().stream())
                .distinct()
                .forEach(System.out::println);


        // Operazioni finali
        // Sono tutte quelle operazioni che mi restituiscono un valore finale
        // Terminando la manipolazione dello Stream

        // Matching
        // Reduction
        // Collection

        Stream<Integer> myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        //myStreamNum.forEach(System.out::println);

        // Reduction
        int num = myStreamNum.reduce(0, (acc, val) -> acc + val);
        System.out.println(num);

        /*
        Equivalente al reduce
        int acc = 0;
        for(int i=0; i<20; i++) {
            acc = acc + i;
        }*/

        // Matching
        myStreamNum = Stream.iterate(0, n -> n+2).limit(10); // 0 -> 18
//        myStreamNum.anyMatch(e -> e > 5); // true
//        myStreamNum.allMatch(e -> e > 5); // false
//        myStreamNum.noneMatch(e -> e > 5); // false

        boolean calcio = userList
                            .stream()
                            .allMatch(u -> u.getHobby().contains("Calcio"));
        System.out.println(calcio);

        // Collection
        // .collect(Collectors.toSet()) -> Set<E>
        // .collect(Collectors.toList()) -> Lis<E>
        // .collect(Collectors.toMap()) -> Map<K,E>
        Stream<Double> myStreamRand = Stream.generate(new Random()::nextDouble).limit(10);
        Set<Long> numberRandom = myStreamRand.map(n -> n * 100)
                .map(Math::round)
                .collect(Collectors.toSet());
        numberRandom.forEach(System.out::println);

        //myStreamRand.forEach(System.out::println);
    }

    public static void testLambdaFunction() {
        // () => { blocco di istruzioni }
        // (param) => { blocco di istruzioni }
        // (param1, param2, ..., paramN) => { blocco di istruzioni }


        /*List<String> lista = new ArrayList<String>();
        lista.add("Ciao");
        lista.add("abc");
        lista.add("testo");*/

        List<String> lista = List.of("Ciao", "abc", "testo");

        /*for(String str : lista){
            System.out.println(str);
        }*/

        lista.forEach(e -> System.out.println(e));
        //lista.forEach(System.out::println);
    }


}


