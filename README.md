# Flixster-App
# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).


## Flix Part 1

### User Stories

#### REQUIRED 
- [✔️ ] User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [ ✔️] Views should be responsive for both landscape/portrait mode.
   - [✔️ ] In portrait mode, the poster image, title, and movie overview is shown.
   - [✔️ ] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [🚧] (**In-Progress**) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [🚧] (**In-Progress**) Improved the user interface by experimenting with styling and coloring.
- [🚧] (**In-Progress**) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
 
<img src="http://g.recordit.co/Fb9tAJbVMV.gif" width=250><br>
<br>
<img src="http://g.recordit.co/pj569sTmsl.gif" width=250><br>


### Notes
Android studio was really bugging out. Messing my recycler view, and me too 

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
