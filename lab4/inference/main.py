import http
import json

import requests

def main():
    url = 'http://localhost:8080'
    with open('test.json', 'r') as f:
        test = json.loads(f.read())
    get = f'{url}/result?packageId=11'
    r = requests.post(f'{url}/test', json=test)
    assert r.status_code == http.HTTPStatus.OK

if __name__ == '__main__':
    main()