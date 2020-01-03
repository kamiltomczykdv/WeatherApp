package com.example.weatherapp.DI

import dagger.Module

@Module(subcomponents = [MainComponent::class,CardComponent::class])
class AppSubcomponents