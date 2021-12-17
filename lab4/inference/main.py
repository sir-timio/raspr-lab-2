import http
import json

import requests

def main():
    url = 'http://localhost:8080'
    test = {
        "packageI": "11",
        "jsScript": "var divideFn = function(a,b) { return a/b} ",
        "functionName": "divideFn",
        "tests": [
            {"testName": "test1",
             "expectedResult": "2.0",
             "params": [2, 1]
             },
            {"testName": "test2",
             "expectedResult": "2.0",
             "params": [4, 2]
             }
        ]
    }
    get = f'{url}/result?packageId=11'
    r = requests.post(f'{url}/test', data=test)
    print(r)
    assert r.status_code == http.HTTPStatus.OK
    r = requests.get(get)
    print(r)



if __name__ == '__main__':
    main()