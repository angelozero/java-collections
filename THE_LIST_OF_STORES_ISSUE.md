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