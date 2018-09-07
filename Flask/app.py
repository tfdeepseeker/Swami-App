from flask import Flask, render_template, request
import requests
from bs4 import BeautifulSoup
import random

app = Flask(__name__)


def quote():
    l = ["Love All Serve All","Help Ever Hurt Never","Love is God Live in Love"]
    return random.choice(l)

@app.route('/')
def index():
    return quote()
    #return render_template('index.html')


@app.route('/suggestions')
def suggestions():
    text = request.args.get('jsdata')

    suggestions_list = []

    suggestions_list.append(text.split(' '))

    return render_template('suggestions.html', suggestions=suggestions_list)


if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True)#,ssl_context=(('cert.pem', 'key.pem')))
    #app.run(host='0.0.0.0',debug=True,ssl_context=(('cert.pem', 'key.pem')))
