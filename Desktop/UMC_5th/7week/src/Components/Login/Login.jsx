import React, { useState, useEffect } from 'react';
import Header from "../Header"
import  "./Login.css"
import { Link } from 'react-router-dom';
function Login() {
  const [form, setForm] = useState({
    email: '',
    password: '',
  });

  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [isButtonActive, setButtonActive] = useState(false);
  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(form);

  };

  const validateEmail = () => {
    const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!re.test(form.email)) {
      setEmailError('올바른 이메일 주소를 입력해주세요.');
    } else {
      setEmailError('');
    }
  };

  const validatePassword = () => {
    const pw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    if (!pw.test(form.password)) {
      setPasswordError('비밀번호는 최소 8자리, 하나의 대문자, 하나의 소문자, 하나의 숫자, 하나의 특수 문자를 포함해야 합니다.');
    } else {
      setPasswordError('');
    }
  };

  useEffect(() => {
    if (emailError === '' && passwordError === '' && form.email !== '' && form.password !== '') {
      setButtonActive(true);
    } else {
      setButtonActive(false);
    }
  }, [form, emailError, passwordError]);

  return (
    <div>
      <Header/>
      <div className="box1">
        <div className="login_h1_box">
          <h1 className="login_h1"> 이메일과 비밀번호를 <br/> 입력해주세요 <hr/></h1> 
        </div>
        <form className="input_box" onSubmit={handleSubmit}>
          <div>
            <p>이메일 주소</p>
            <input type="email" name="email" value={form.email} onChange={handleChange} onBlur={validateEmail} placeholder='이메일을 입력하세요'/>
            {emailError && <span className="error">{emailError}</span>}
          </div>
          <div>
            <p>비밀번호</p>
            <input type="password" name="password" value={form.password} onChange={handleChange} onBlur={validatePassword} placeholder='영문,숫자,특수문자 포함 8자이상' />
            {passwordError && <span className="error">{passwordError}</span>}
          </div>
          <br/>
          <Link to = "/"><button className={`submit_button ${isButtonActive ? 'active' : ''}`}type="submit">가입하기</button></Link>
        </form>
      </div>
    </div>
  );
}

export default Login;
