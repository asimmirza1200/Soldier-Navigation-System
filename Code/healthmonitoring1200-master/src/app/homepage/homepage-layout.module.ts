import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

import { HomePageRoutes } from "./homepage-routing.module";


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(HomePageRoutes),
    FormsModule,
    HttpClientModule,
  ],
  declarations: [
  
  ]
})
export class HomePageLayoutModule {}
