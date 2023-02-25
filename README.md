# Java 8

![collections](https://i.postimg.cc/tRdKP7xb/collections-java.png)

## Laços em Java

**For**

- O laço ```for``` é recomendado para ser usado quando temos um número fixo de iterações necessárias para o loop.

```javascript
for ( inicialização da variável; condição; alteração da variável ) {  
       [ comando ]
}

// Código
for(int count=10 ; count >= 1; count--){
    System.out.println(count);
}
```

---
**For-each**

- ```for-each``` pode ser traduzido como “para cada”. É um laço For que busca uma correspondência pré-determinada para
  funcionar.

```javascript
for ( tipo da variável: array ) 
{ 
    comandos usando a variável;
}

// Código
public static void main(String[] arg){
    
    int[] pontos = { 101, 102, 95, 106, 160 };
    int h_pontos = maximum(pontos);
    System.out.println("A melhor pontuação é " + h_pontos);

}

public static int maximum(int[] numbers) {
    int pontMax = numbers[0];
    
    for (int num : numbers){
        if (num > pontMax){
            pontMax = num;
        }
    }
    
    return pontMax;
}
```

## Ordenando no Java 8

**Interface Comparator**

- Além de poder ter métodos default dentro de uma interface, agora podemos ter métodos estáticos. A interface Comparator
  possui alguns deles.

- O nosso ```user.sort(...)``` pode ficar ainda mais curto, com o auxílio do ```Comparator.comparing(...)```, que é
  uma **fábrica (*factory*)** de Comparators.

```javascript
Comparator<User> comparator = Comparator.comparing(u -> u.getNome()); usuarios.sort(comparator);
```

- Ele retorna um ```Comparator``` que usará a String do nome de usuário como critério de comparação.

**Natural Order**

- ```Comparator.naturalOrder()``` retorna um Comparator que delega para o próprio objeto. Há também
  o ```Comparator.reverseOrder()```.

```javascript
List<String> words = Arrays.asList("Spain", "Brazil", "Japan");
words.sort(Comparator.naturalOrder());
```

---

## Method References

- A sintaxe é bem simples

```javascript
users.forEach(User::turnModerator);
```

- O method reference (```User::turnModerator```) é traduzido para uma interface funcional. Aqui não há reflection sendo utilizada, tudo é resolvido em tempo de compilação, sem custos de overhead para a
  performance.

- Para Referenciar construtores podemos usar da seguinte maneira

```javascript
public User execute() {

    Supplier<User> createNewUser = User::new;

    return createNewUser.get();
}
```

- Para referenciar um construtor passando mais de uma parametro podemos criar uma interface funcional ou usar a ja existente biFunction

```javascript
public User execute() {

    BiFunction<String, Integer, User> createNewUser = User::new;

    return createNewUser.apply("Angelo - Supplier Bi Function", 10);

}
```
---

## Streams e Collectors

- Stream nunca guarda dados. Ele não tem uma estrutura de dados interna para armazenar cada um dos elementos: ele, na verdade, usa uma coleção ou alguma outra categoria de fonte para trabalhar com os objetos e executar uma série de operações (um `pipeline` de operações). Ele está mais próximo a um Iterator. O Stream é uma sequência de elementos que pode ser trabalhada de diversas formas.

```javascript
return users.stream().filter(user -> user.getPoints() > 25).collect(Collectors.toList()); 
```

- Sobre Collectors

```javascript
<R> R collect(Supplier<R> supplier,
  BiConsumer<R, ? super T> accumulator,
  BiConsumer<R, R> combiner);
```
- A função recebe três argumentos. Os três são `interfaces` funcionais. O primeiro é uma factory que vai criar o objeto que será devolvido no final da coleta. O segundo é o método que será invocado para adicionar cada elemento. O terceiro pode ser invocado se precisarmos adicionar mais de um elemento em simultâneo (por exemplo, se formos usar uma estratégia de coletar elementos paralelamente, como veremos no futuro).

- FlatMap - Listando todos os arquivos na pasta service
```javascript
  Map<Path, Long> linesPerFile = new HashMap<>();
  try {
      list(Paths.get("src/main/java/com/angelozero/collections/service/"))
              .filter(p -> p.toString().endsWith(".java"))
              .forEach(p ->
              {
                  try {
                      linesPerFile.put(p.getFileName(), lines(p).count());
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }
              });
      return linesPerFile;
```

## Parallel Stream

- As collections oferecem uma implementação de Stream diferente, o stream paralelo. Ao usar um stream paralelo, ele vai decidir quantas threads deve utilizar, como
deve quebrar o processamento dos dados e qual será a forma de unir o resultado final em um só. Tudo isso sem você ter de configurar nada. Basta apenas invocar
parallelStream em vez de Stream:

```javascript
        double startTimeWithParallel = (double) System.nanoTime() / 1_000_000_000;
        LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        double stopTimeWithParallel = (double) System.nanoTime() / 1_000_000_000;


        double startTimeWithoutParallel = (double) System.nanoTime() / 1_000_000_000;
        LongStream.range(0, 1_000_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        double endTimeWithoutParallel = (double) System.nanoTime() / 1_000_000_000;


        // this is just an example and will print 
        // "Time with Parallel   ": "1.47 seconds",
        // "Time without Parallel": "2.30 seconds"
}
```

![parallel](https://2.bp.blogspot.com/-6mu_XONMqYY/XD6INZpldiI/AAAAAAAANAU/s6_J24LaAIgCU5rfd0mvIsTuBqlntQCygCLcBGAs/w1200-h630-p-k-no-nu/stream_performance_Java8_collection.png)