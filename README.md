# Java 8
![collections](https://i.postimg.cc/tRdKP7xb/collections-java.png)

## Laços em Java

**For**
- O laço ```for``` é recomendado para ser usado quando temos um número fixo de iterações necessárias para o loop.

```java
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
- ```for-each``` pode ser traduzido como “para cada”. É um laço For que busca uma correspondência pré-determinada para funcionar.

```java
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
- Além de poder ter métodos default dentro de uma interface, agora podemos ter métodos estáticos. A interface Comparator possui alguns deles.

- O nosso ```user.sort(...)``` pode ficar ainda mais curto, com o auxílio do ```Comparator.comparing(...)```, que é uma **fábrica (*factory*)** de Comparators.
```java
Comparator<User> comparator = Comparator.comparing(u -> u.getNome()); usuarios.sort(comparator);
```
- Ele retorna um ```Comparator``` que usará a String do nome de usuário como critério de comparação.