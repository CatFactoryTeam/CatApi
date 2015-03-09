# CatApi

**A RESTful API filled with cats**

*A CatFactory project*

## Environment variables

| Variables     | Info           |
|---------------|----------------|
| IMGUR_KEY     | Imgur API key  |
| IMGUR_ALBUM   | Imgur album id |

Pretty obvious, right ?

## API

Responses are in JSON, following this format :
```json
{
  "status": "success || error",
  "data": "..."
}
```

### GET /cats

Returns all the cats

```json
{
  "status":"success",
  "data":[
    {"id":"e6Zzs32","link":"http://i.imgur.com/e6Zzs32.gif"},
    {"id":"QfkRzru","link":"http://i.imgur.com/QfkRzru.gif"},
    {"id":"CzmaAEF","link":"http://i.imgur.com/CzmaAEF.gif"},
    "..."
  ]
}
```
