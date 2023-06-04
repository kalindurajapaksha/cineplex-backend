# cineplex-backend

Foobar is a Python library for dealing with word pluralization.

## Installation


```bash
./mvnw clean install
```

## Usage
### User endpoints
POST http://localhost:8080/movie/  
sample body:
```json
{
    "name": "Sample movie - 01",
    "image": "https://leosigh.com/wp-content/uploads/2023/03/Korean-movie-Swallow-poster.jpg",
    "description": "This is a sample movie.",
    "availableSeats": 3, //max 10
    "showtimes": [1,2] //showtime ids **
}
```
**There are 3 predefined showtimes:  
id: 1 label: 10:00 AM  
id: 2 label: 02:00 PM  
id: 3 label: 06:00 PM


