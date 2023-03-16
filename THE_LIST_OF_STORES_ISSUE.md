# The list of stores issue

![paradox](https://media.tenor.com/0LZHQE3DeucAAAAC/time-paradox-mgs3.gif)

## What I have

```json
[
    {
        "superStoreList": [
            {
                "name": "Super Store 1",
                "storeList": [
                    {
                        "code": "001",
                        "name": "AAA",
                        "value": 10
                    },
                    {
                        "code": "002",
                        "name": "BBB",
                        "value": 20
                    },
                    {
                        "code": "003",
                        "name": "CCC",
                        "value": 30
                    }
                ]
            },
            {
                "name": "Super Store 2",
                "storeList": [
                    {
                        "code": "001",
                        "name": "AAA",
                        "value": 10
                    },
                    {
                        "code": "002",
                        "name": "BBB",
                        "value": 40
                    },
                    {
                        "code": "005",
                        "name": "EEE",
                        "value": 50
                    }
                ]
            }
        ]
    },
    {
        "superStoreList": [
            {
                "name": "Super Store 3",
                "storeList": [
                    {
                        "code": "001",
                        "name": "AAA",
                        "value": 10
                    },
                    {
                        "code": "006",
                        "name": "FFF",
                        "value": 60
                    },
                    {
                        "code": "007",
                        "name": "GGG",
                        "value": 70
                    }
                ]
            },
            {
                "name": "Super Store 4",
                "storeList": [
                    {
                        "code": "001",
                        "name": "AAA",
                        "value": 10
                    },
                    {
                        "code": "008",
                        "name": "HHH",
                        "value": 80
                    },
                    {
                        "code": "009",
                        "name": "ZZZ",
                        "value": 90
                    }
                ]
            }
        ]
    }
]
```

## What I need ( and did as the solution )

```json
{
    "superStoreList": [
        {
            "name": "Final Store Name",
            "storeList": [
                {
                    "code": "001",
                    "name": "AAA",
                    "value": 40
                },
                {
                    "code": "002",
                    "name": "BBB",
                    "value": 60
                },
                {
                    "code": "003",
                    "name": "CCC",
                    "value": 30
                },
                {
                    "code": "005",
                    "name": "EEE",
                    "value": 50
                },
                {
                    "code": "006",
                    "name": "FFF",
                    "value": 60
                },
                {
                    "code": "007",
                    "name": "GGG",
                    "value": 70
                },
                {
                    "code": "008",
                    "name": "HHH",
                    "value": 80
                },
                {
                    "code": "009",
                    "name": "ZZZ",
                    "value": 90
                }
            ]
        }
    ]
}
``` 

- The logic behind

```java
public class GetConsolidatedInformation {

    public MasterStore execute() {

        List<MasterStore> masterStoreList = GenetareMasterStores.execute();

        List<Store> storeList = new ArrayList<>();
        List<Store> storeFinalList = new ArrayList<>();

        masterStoreList.forEach(masterStore -> masterStore.getSuperStoreList().forEach(superStore -> storeList.addAll(superStore.getStoreList())));

        for (List<Store> storeMapList : storeList.stream().collect(Collectors.groupingBy(Store::getCode)).values()) {
            storeFinalList.add(sumStores(storeMapList));
        }

        return MasterStore.builder()
                .superStoreList(Collections
                        .singletonList(
                                SuperStore.builder()
                                        .name("Final Store Name")
                                        .storeList(storeFinalList)
                                        .build()))
                .build();
    }

    private Store sumStores(List<Store> storeList) {
        return storeList.stream()
                .collect(Collectors.teeing(
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Store::getCode))),
                        Collectors.summingInt(Store::getValue), (optionalMax, sum) ->
                                new Store(optionalMax.get().getCode(), optionalMax.get().getName(), sum)));
    }
}
```