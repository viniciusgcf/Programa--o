
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>Login</title>
    @vite('resources/css/app.css')
</head>
<body>
    <a href="{{ route('home') }}">Home</a>
    <a href="{{ route('teste') }}">Teste</a>

    @if (session()->has('success'))
        {{ session()->get('success') }}
    @endif

    @if (auth()->check())
    Logged in as {{ auth()->user()->name}}  | <a href="{{ route('login.destroy')}}">Logout</a>
    @else

    @error('error')
        <span>{{ $message }}</span>
    @enderror

<div class="login-box">
    <div class="login-header">
        <header>Login</header>
    </div>
    <form action="{{ route('login.store') }}"method="post">
    @csrf
    <input type="text" name="email" class="input-field" autocomplete="off" required>
    @error('email')
    <span>{{$message}}</span>
    @enderror
    <input type="password" name="password" class="input-field"  autocomplete="off" required>
    @error('password')
    <span>{{$message}}</span>
    @enderror
    <button type="submit">Login</button>
    </form>
    <div class="forgot">
        <section>
            <input type="checkbox" id="check">
            <label for="check">Lembrar</label>
        </section>
        <section>
            <a href="#">Esqueceu a senha?</a>
        </section>
    </div>
    <div class="input-submit">
        <button class="submit-btn" id="submit"></button>
        <label for="submit">Entrar</label>
    </div>
    <div class="sign-up-link">
        <p>Não tem uma conta? <a href="#">Criar conta</a></p>
    </div>
</div>
@endif

</body>
</html>
