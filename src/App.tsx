import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import { Navigate, Route, Routes } from "react-router-dom";
import Movies from "./pages/Movies";
import { useEffect, useState } from "react";
import axios from "axios";
import MovieLayout from "./pages/MovieLayout";
import Movie from "./pages/Movie";
import SeatBooking from "./pages/SeatBooking";

export type Movie = {
  id: string;
  title: string;
  rank: number;
  thumbnail: string;
  rating: string;
  year: number;
  image: string;
  description: string;
  trailer: string;
  genre: string[];
  director: string[];
  writers: string[];
};

function App() {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [genres, setGenres] = useState<string[]>([]);

  const createGenresList = (movies: Movie[]) => {
    const arr: string[] = [];
    movies.forEach((movie) => {
      if (movie.genre.length > 0) {
        movie.genre.forEach((g) => {
          if (!arr.includes(g)) arr.push(g);
        });
      }
    });
    setGenres(arr);
  };

  useEffect(() => {
    const fetchMovies = async () => {
      const options = {
        method: "GET",
        url: "https://imdb-top-100-movies.p.rapidapi.com/",
        headers: {
          "X-RapidAPI-Key":
            "7d88a16cc9mshe0da1cb4d88d75ap17ebdbjsn89b117907f64",
          "X-RapidAPI-Host": "imdb-top-100-movies.p.rapidapi.com",
        },
      };
      try {
        const response = await axios.request(options);
        console.log(response.data);
        setMovies(response.data);
        createGenresList(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchMovies();
  }, []);

  return (
    <Container className="my-4">
      <Routes>
        <Route path="/" element={<Movies movies={movies} genres={genres} />} />
        <Route path="/:id" element={<MovieLayout movies={movies} />}>
          <Route index element={<Movie />} />
          <Route path="book-seats" element={<SeatBooking />} />
        </Route>
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </Container>
  );
}

export default App;
