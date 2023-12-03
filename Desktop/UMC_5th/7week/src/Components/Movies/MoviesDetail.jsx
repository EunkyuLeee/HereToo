import { useLocation, useParams } from 'react-router-dom'
import Header from '../Header';

export default function MovieDetail() {
    const { title } = useParams();
    const { poster_path } = useLocation().state;
    const getImageUrl = (path, size = 300) => {
        return `https://image.tmdb.org/t/p/w${size}${path}`;
    }
    
    return (
        <div>
            <Header/>
            <h1>{title}</h1>  
            <img src={getImageUrl(poster_path)} alt={title} /> 
        </div>
    )
}
