import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { UserModule } from './user/user.module';
import { UserRoutingModule } from './user/user-routing.module';
import { HttpClientModule } from "@angular/common/http";
import { UserService } from './user/services/user.service';
import { FormsModule } from '@angular/forms';
import { AuthGuard } from './user/gaurd/auth.gaurd'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    UserModule,
    HttpClientModule,
    FormsModule,
    UserRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})


export class AppModule { }
