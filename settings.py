from requests_oauthlib.oauth2_session import OAuth2Session
from flask import Flask

class MyClass(object):
    def __init__(self):
        self.message = 'Hello'
        return self

DATABASES = {
    'postgresql_db': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': 'quickdb',
        'USER': 'sonarsource',
        'PASSWORD': '', # Noncompliant
        'HOST': 'localhost',
        'PORT': '5432'
    }
}

app = Flask(__name__)
app.config['SECRET_KEY'] = "secret"

scope = ['https://www.api.example.com/auth/example.data']

oauth = OAuth2Session(
    'example_client_id',
    redirect_uri='https://callback.example.com/uri',
    scope=scope)

token = oauth.fetch_token(
        'https://api.example.com/o/oauth2/token',
        client_secret='example_Password')
