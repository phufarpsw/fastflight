import Vue from 'vue'
import App from './App.vue'
import router from './router'
// import { fab } from '@fortawesome/free-brands-svg-icons'
import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import Vuelidate from 'vuelidate'
import vSelect from 'vue-select'

import '../public/css/style.css'
library.add(fas)
Vue.component('v-select', vSelect)
Vue.component('icon', FontAwesomeIcon)

Vue.use(Vuelidate)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
