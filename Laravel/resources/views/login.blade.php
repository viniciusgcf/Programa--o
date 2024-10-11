
    <a href="{{ route('home') }}">Home</a>

    <h2>Login</h2>

    @if (session()->has('success'))
        {{ session()->get('success') }}
    @endif

    @if (auth()->check())
    Logged in as {{ auth()->user()->name}}  | <a href="{{ route('login.destroy')}}">Logout</a>
    @else

    @error('error')
        <span>{{ $message }}</span>
    @enderror

    <form action="{{ route('login.store') }}"method="post">
        @csrf
        <input type="text" name="email" value="teste@gmail.com">
        @error('email')
            <span>{{$message}}</span>
        @enderror
        <input type="password" name="password" value="teste12345">
        @error('password')
            <span>{{$message}}</span>
        @enderror
        <button type="submit">Login</button>
    </form>

    @endif

