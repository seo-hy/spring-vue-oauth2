<template>
  <div class="form">
    <div class="form__title">Log In</div>
    <form>
      <div class="social-login">
        <img src="@/assets/login/google-login.png" />
        <img src="@/assets/login/kakao-login.png" />
        <img src="@/assets/login/naver-login.png" />
      </div>
      <div class="form__or">or</div>
      <div class="form__field">
        <label for="id"><i class="fa fa-envelope"></i> Email</label>
        <input type="text" name="id" placeholder="Enter your email" />
      </div>
      <div class="form__field">
        <label for="password"><i class="fa fa-key"></i> Password</label>
        <input type="password" name="password" placeholder="Enter your password" />
      </div>

      <div class="form__btn">
        <button class="form__btn-main" type="submit">Submit</button>
      </div>
    </form>
    <div class="form__btn">
      <button class="form__btn-sub" @click="$router.push({ name: 'signup' })">Sign Up</button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.form {
  font-family: "Noto Sans", sans-serif;
  width: 400px;
  height: 470px;
  margin: 80px auto;
  background-color: white;
  border-radius: 25px;
  -webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.1);
}
.form__title {
  text-align: center;
  padding: 20px 0;
  font-size: 30px;
  font-weight: 600;
  color: #3b3b3b;
  box-shadow: inset 0px -2px 0px 0px #f8f8f8;
  text-shadow: 2px 2px 2px rgba(204, 204, 204, 0.658);
}
.form__field {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 20px;
}
.form__btn {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 15px;
}
.form__field input {
  width: 80%;
  border: none;
  font-size: 1rem;
  padding-top: 5px;
  padding-left: 20px;
  padding-bottom: 12px;
  box-shadow: inset 0px -2px 0px 0px rgba(187, 187, 187, 0.2);
  transition: box-shadow 0.2s ease-in;
  color: #3b3b3b;
}
.form__field input::placeholder {
  color: #b3b3b3;
}
.form__field input:focus {
  box-shadow: inset 0px -2px 0px 0px rgba(201, 201, 201, 0.9);
  outline: none;
}
.form__field input:hover {
  box-shadow: inset 0px -2px 0px 0px rgba(201, 201, 201, 0.9);
  outline: none;
}
.form__field input::-webkit-input-placeholder {
  opacity: 1;
  transition: opacity 0.25s ease-out;
}

.form__field label {
  align-self: start;
  padding-left: 50px;
  padding-bottom: 5px;
  font-size: 13px;
  color: rgba(151, 151, 151, 0.9);
}

button {
  border-radius: 25px;
  width: 85%;
  height: 40px;
  line-height: 40px;
  font-size: 20px;
  color: white;
  font-weight: 600;
  background: #aaaaaae0;
  /* background: linear-gradient(90deg, #b0bfda91 0%, #e0cdcd 100%); */
  border: none;
  cursor: pointer;
  transition: opacity 0.25s ease-out;
  box-shadow: 2px 3px 3px rgb(221, 221, 221);
}
.form__btn-main {
  background: #b09ebde0;
}
.form__btn-sub {
  background: #c0b6c7e0;
}
button:hover {
  opacity: 0.8;
}
.social-login {
  padding-top: 20px;
  width: 300px;
  text-align: center;
  margin: 0 auto;
}
.social-login > img {
  width: 40px;
  margin: 0 10px;
  filter: drop-shadow(2px 2px 2px rgb(185, 185, 185));
  opacity: 0.9;
}
.social-login > img:hover {
  opacity: 0.7;
}
.form__or {
  width: 100%;
  text-align: center;
  margin: 10px 0;
  color: #bbbbbb;
}
.form__btn-main {
  margin-top: 5px;
}
</style>
