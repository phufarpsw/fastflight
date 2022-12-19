import Vue from 'vue'
import App from './App.vue'
import router from './router'
// import { fab } from '@fortawesome/free-brands-svg-icons'
import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import Vuelidate from 'vuelidate'

import '../public/css/style.css'
import AxiosPlugin from 'vue-axios-cors';
library.add(fas)
Vue.component('icon', FontAwesomeIcon)

Vue.use(Vuelidate)
// Vue.use(cors({ origin: ['http://localhost:8081'], }))
// Vue.http.headers.common['Access-Control-Allow-Origin'] = '*'
// Vue.http.options.emulateJSON = true
// Vue.http.headers.common['Access-Control-Allow-Origin'] = true
// Vue.http.options.credentials = true
// Vue.http.options.emulateHTTP = true
// Vue.http.headers.common['X-Requested-With'] = 'XMLHttpRequest';
// Vue.http.headers.common['Access-Control-Allow-Origin'] = 'http://localhost:8081'
// Vue.http.headers.common['Access-Control-Request-Method'] = '*'
// Vue.use(cors(corsConfig));

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
