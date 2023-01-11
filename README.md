# Java 8
![collections](https://i.postimg.cc/tRdKP7xb/collections-java.png)

## Ordenando no Java 8
**Interface Comparator**
- Além de poder ter métodos default dentro de uma interface, agora podemos ter métodos estáticos. A interface Comparator possui alguns deles.

- O nosso ```user.sort(...)``` pode ficar ainda mais curto, com o auxílio do ```Comparator.comparing(...)```, que é uma **fábrica (*factory*)** de Comparators.
```java
Comparator<User> comparator = Comparator.comparing(u -> u.getNome()); usuarios.sort(comparator);
```
- Ele retorna um ```Comparator``` que usará a String do nome de usuário como critério de comparação.