<?php

use App\Http\Controllers\HomeController;
use App\Http\Controllers\LoginController;
use Illuminate\Support\Facades\Route;
use App\Models\User;

Route::get('/', [HomeController::class, 'index'])->name('home');

Route::get('/teste', function () {
    var_dump('login view');
})->middleware('can:login_page')->name('teste');

// Route::get('/master', [HomeController::class, 'index'])->name('home');

Route::controller(LoginController::class)->group(function () {
    Route::get('/login', 'index')->name('login.index');
    Route::post('/login', 'store')->name('login.store');
    Route::get('/logout', 'destroy')->name('login.destroy');
});



