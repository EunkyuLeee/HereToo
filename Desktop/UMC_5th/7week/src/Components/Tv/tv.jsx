import Header from '../Header';
import  {tv_dummy}  from '../tvDummy';

function Tv() {

    const getImageUrl = (path, size = 500) => {
        return `https://image.tmdb.org/t/p/w${size}${path}`;
    }
    
  return (
    <div>
        <Header/>
        <div>
            {
                tv_dummy.results.map((item, index) => {
                    return(
                        <div key={index}>
                            <h3>{item.name}</h3>
                            <img src = {getImageUrl(item.poster_path)}></img>
                            <p>{item.vote_average}</p>
                            <p>{item.overview}</p>
                        </div>
                    )
                })
            }
        </div> 
    </div>
  );
}

export default Tv;
