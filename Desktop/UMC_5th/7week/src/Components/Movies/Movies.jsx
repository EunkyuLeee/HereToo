import MovieList from './MovieList.style';
import { dummy } from '../movieDummy';
import Header from '../Header';

function Movies() {

  return (
    <div>
        <Header/>
        <div className='app-container'>
            {
              dummy.results.map((item) => {
                return(
                  <MovieList
                    title={item.title}
                    poster_path={item.poster_path}
                    vote_average={item.vote_average}
                    overview={item.overview}
                  />
                )
              })
            }
        </div>
    </div>
  );
}

export default Movies;

