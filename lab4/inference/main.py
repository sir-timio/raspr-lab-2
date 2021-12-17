import http
import json

import requests

def main():
    url = 'http://localhost:8080'
    post = """
        {
        "packageId":"11",
        "jsScript":"var divideFn = function(a,b) { return a/b} ",
        "functionName":"divideFn",
        "tests": [
        {"testName":"test1",
        "expectedResult":"2.0",
        "params":[2,1]
        },
        {"testName":"test2",
        "expectedResult":"2.0",
        "params":[4,2]
        }
        ]
        }"""

    get = f'{url}/<url>?packageId=11'
    r = requests.post(url, json=json.dumps(post))
    assert r.status_code == http.HTTPStatus.OK
    r = requests.get(get)
    print(r)



if __name__ == '__main__':
    main()