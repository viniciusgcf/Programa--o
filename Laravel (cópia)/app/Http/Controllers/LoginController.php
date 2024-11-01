<?php

namespace App\Http\Controllers;

use App\Models\User;
use Auth;
use Illuminate\Http\Request;


class LoginController extends Controller
{
    public function index()
    {
        return view('login');
    }

    public function store(request $request)
    {
        $request->validate([
            'email' => 'required|email',
            'password' => 'required|min:8'
        ], [
            'email.required' => 'O campo de email é obrigatório',
            'email.email' => 'É necessário um email válido',
            'password.required' => 'O campo de senha é obrigatório',
            'password.min' => 'É necessário que a senha tenha no minímo :min caracteres',
        ]);

        $user = User::where('email', $request->input('email'))->first();

        $user->password = bcrypt($request->input('password'));


        if (! $user || ! password_verify($request->input('password'), $user->password)) {
            return redirect()->route('login.index')->withErrors(['error' => 'Email ou senha inválidos']);
        }

        Auth::loginUsingId($user->id);

        return redirect()->route('login.index')->with('success');

        // $credentials = $request->only('email', 'password');
        // $authenticated = Auth::attempt($credentials);

        // if (! $authenticated) {
        //     return redirect()->route('login.index')->withErrors(['error' => 'Email ou senha inválidos']);
        // }

        // return redirect()->route('login.index')->with('success', 'Logged in');
    }

    public function destroy()
    {
        Auth::logout();

        return redirect()->route('login.index');
    }
}
