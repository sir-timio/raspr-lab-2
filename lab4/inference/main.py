import http
import json

import requests

def main():
    url = 'http://localhost:8080'
    test = json.loads('test.json')
    print(test)
    get = f'{url}/result?packageId=11'
    r = requests.post(f'{url}/test', data=json.)
    print(r)
    assert r.status_code == http.HTTPStatus.OK
    r = requests.get(get)
    print(r)



if __name__ == '__main__':
    main()