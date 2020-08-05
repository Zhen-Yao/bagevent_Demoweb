const login_button1= button1;
const value1= '使用邮箱登录';
const login_button2= button2;
const value2= '使用手机号登录';
const title1 = login;
const title_value1= '登录';
const title2= registered;
const title_value2= '注册';
const registered_button1 = button3;
const registered_value1= '使用邮箱注册';
const registered_button2= button4;
const registered_value2= '使用邮箱注册';
class Login extends React.Component{
  render() {
    return (
    <div>
    <input type="button" onClick={login_button1} value={value1}/>
    <input type="button" onClick={login_button2} value={value2}/>
    </div>);
  }
};
class Title extends React.Component{
  render() {
    return (
    <div>
     <button  onClick={title1}>{title_value1}</button>
     <button  onClick={title2}>{title_value2}</button>
    </div>);
  }
};
class Registered extends React.Component{
  render() {
    return (
    <div>
        <input type="button" onClick={registered_button1} value={registered_value1}/>
        <input type="button" onClick={registered_button2} value={registered_value2}/>
    </div>);
  }
};
ReactDOM.render(
  <Login/>,
  document.getElementById('login1')
);

ReactDOM.render(
  <Title/>,
  document.getElementById('title')
);
ReactDOM.render(
  <Registered/>,
  document.getElementById('registered1')
);