import React, { useState } from 'react';
import "./Header.css"
import { Link } from 'react-router-dom';


function Header (){

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const handleLoginClick = () => {
        setIsLoggedIn(!isLoggedIn);
    }

    return(
        <div>
            <header className='header'>
                <div className='header-menu'>
                    <Link to = "/">
                    <img
                        style={{ width: "154px", height: "20px" }}
                        src="https://www.themoviedb.org/assets/2/v4/logos/v2/blue_short-8e7b30f73a4020692ccca9c88bafe5dcb6f8a62a4c6bc55cd9ba82bb2cd95f6c.svg"
                        alt="로고"
                    />
                    </Link>
                    <nav className='menu'>
                        <ul className='menu-ul'>
                            <li><Link to = "/movie">영화</Link></li>
                            <li><Link to = "/tv">TV 프로그램</Link></li>
                            <li><Link to = "/person">인물</Link></li>
                        </ul>
                    </nav>

                    {!isLoggedIn && (<span className="loginStatus">로그인해주세요!</span>)}
                    {isLoggedIn && (<span className="loginStatus">환영합니다!</span>)}
                    <Link to = "/login"><button className='login-button' onClick={handleLoginClick}>
                        {isLoggedIn ? '로그아웃' : '로그인'}
                    </button></Link>

                </div>
            </header>
        </div>
    );
}
export default Header;
